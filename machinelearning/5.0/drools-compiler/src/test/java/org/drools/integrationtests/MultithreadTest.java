/*
 * Copyright 2008 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created on Feb 5, 2008
 */

package org.drools.integrationtests;

import junit.framework.TestCase;
import org.drools.Child;
import org.drools.GrandParent;
import org.drools.Order;
import org.drools.Parent;
import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.StatefulSession;
import org.drools.compiler.PackageBuilder;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * This is a test case for multi-thred issues
 * 
 * @author etirelli
 */
public class MultithreadTest extends TestCase {

    /**
     * @inheritDoc
     *
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * @inheritDoc
     *
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testRuleBaseConcurrentCompilation() {
        final int THREAD_COUNT = 30;
        try {
            boolean success = true;
            final PackageBuilder builder = new PackageBuilder();
            builder.addPackageFromDrl( new InputStreamReader( getClass().getResourceAsStream( "test_MultithreadRulebaseSharing.drl" ) ) );
            RuleBase ruleBase = RuleBaseFactory.newRuleBase();
            ruleBase.addPackage( builder.getPackage() );
            ruleBase    = SerializationHelper.serializeObject(ruleBase);
            final Thread[] t = new Thread[THREAD_COUNT];
            final RulebaseRunner[] r = new RulebaseRunner[THREAD_COUNT];
            for ( int i = 0; i < t.length; i++ ) {
                r[i] = new RulebaseRunner( i,
                                           ruleBase );
                t[i] = new Thread( r[i],
                                   "thread-" + i );
                t[i].start();
            }
            for ( int i = 0; i < t.length; i++ ) {
                t[i].join();
                if ( r[i].getStatus() == RulebaseRunner.Status.FAIL ) {
                    success = false;
                }
            }
            if ( !success ) {
                fail( "Multithread test failed. Look at the stack traces for details. " );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            fail( "Should not raise any exception: " + e.getMessage() );
        }
    }

    public static class RulebaseRunner
        implements
        Runnable {

        private static final int ITERATIONS = 300;
        private final int        id;
        private final RuleBase   rulebase;
        private Status           status;

        public RulebaseRunner(final int id,
                              final RuleBase rulebase) {
            this.id = id;
            this.rulebase = rulebase;
            this.status = Status.SUCCESS;
        }

        public void run() {
            try {
                StatefulSession session2 = this.rulebase.newStatefulSession();

                for ( int k = 0; k < ITERATIONS; k++ ) {
                    GrandParent gp = new GrandParent( "bob" );
                    Parent parent = new Parent( "mark" );
                    parent.setGrandParent( gp );

                    Child child = new Child( "mike" );
                    child.setParent( parent );

                    session2.insert( gp );
                    session2.insert( parent );
                    session2.insert( child );
                }

                session2.fireAllRules();
                session2.dispose();

            } catch ( Exception e ) {
                this.status = Status.FAIL;
                System.out.println( Thread.currentThread().getName() + " failed: " + e.getMessage() );
                e.printStackTrace();
            }
        }

        public static enum Status {
            SUCCESS, FAIL
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * @return the status
         */
        public Status getStatus() {
            return status;
        }

    }

    public void testExpectedFires() {
        try {
            final PackageBuilder packageBuilder = new PackageBuilder();
            packageBuilder.addPackageFromDrl( new InputStreamReader( getClass().getResourceAsStream( "test_MultithreadFiringCheck.drl" ) ) );
            final RuleBase ruleBase = RuleBaseFactory.newRuleBase();
            ruleBase.addPackage( packageBuilder.getPackage() );
            final Queue errorList = new ConcurrentLinkedQueue();
            final Thread t[] = new Thread[50];
            for ( int i = 0; i < t.length; i++ ) {
                final int count = i;
                t[i] = new Thread( new Runnable() {
                    public void run() {
                        try {
                            final int iterations = count * 15 + 3000;
                            final List results = new ArrayList();
                            final StatefulSession session2 = ruleBase.newStatefulSession();
                            session2.setGlobal( "results",
                                                results );
                            session2.insert( new Integer( -1 ) );
                            for ( int k = 0; k < iterations; k++ ) {
                                session2.insert( new Integer( k ) );
                                if ( k + 1 != session2.getAgenda().agendaSize() ) {
                                    errorList.add( "THREAD-" + count + " ERROR: expected agenda size=" + (k + 1) + " but was " + session2.getAgenda().agendaSize() );
                                }
                            }
                            session2.fireAllRules();
                            session2.dispose();
                            if ( results.size() != iterations ) {
                                errorList.add( "THREAD-" + count + " ERROR: expected fire count=" + iterations + " but was " + results.size() );
                            }
                        } catch ( Exception e ) {
                            errorList.add( "THREAD-" + count + " EXCEPTION: " + e.getMessage() );
                            e.printStackTrace();
                        }
                    }
                } );
                t[i].start();
            }
            for ( int i = 0; i < t.length; i++ ) {
                t[i].join();
            }
            assertTrue( "Errors during execution: " + errorList.toString(),
                        errorList.isEmpty() );
        } catch ( Exception e ) {
            e.printStackTrace();
            fail( "No exception should have been raised: "+e.getMessage());
        }
    }

    public void testMultithreadDateStringConstraints() {
        try {
            final int THREAD_COUNT = 10;
            final PackageBuilder packageBuilder = new PackageBuilder();
            packageBuilder.addPackageFromDrl( new InputStreamReader( getClass().getResourceAsStream( "test_MultithreadDateStringConstraints.drl" ) ) );
            final RuleBase ruleBase = RuleBaseFactory.newRuleBase();
            ruleBase.addPackage( packageBuilder.getPackage() );
            final Vector errors = new Vector();
            
            final Thread t[] = new Thread[THREAD_COUNT];
            for(int j=0;j<10;j++)
            {
                for (int i = 0; i < t.length; i++) {
                    t[i] = new Thread() {
                        public void run() {
                            try {
                                final int ITERATIONS = 300;
                                StatefulSession session = ruleBase.newStatefulSession();
                                List results = new ArrayList();
                                session.setGlobal( "results", results );
                                for( int k = 0; k < ITERATIONS; k++ ) {
                                    session.insert( new Order() );
                                }
                                session.fireAllRules();
                                session.dispose();
                                if( results.size() != ITERATIONS ) {
                                    errors.add( "Rules did not fired correctly. Expected: "+ITERATIONS+". Actual: "+results.size() );
                                }
                            } catch( Exception ex ) {
                                ex.printStackTrace();
                                errors.add( ex );
                            }
                        }
                        
                    };
                    t[i].start();
                }
                for (int i = 0; i < t.length; i++) {
                    t[i].join();
                }
            }
            if( !errors.isEmpty() ) {
                fail(" Errors occured during execution ");
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            fail( "Should not raise exception" );
        }
    }
}
