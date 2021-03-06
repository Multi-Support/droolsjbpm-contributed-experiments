package org.drools.base.extractors;

import java.lang.reflect.Method;

import org.drools.RuntimeDroolsException;
import org.drools.base.BaseClassFieldExtractor;
import org.drools.base.ValueType;
import org.drools.common.InternalWorkingMemory;

public abstract class BaseObjectClassFieldExtractor extends BaseClassFieldExtractor {

    private static final long serialVersionUID = 400L;

    protected BaseObjectClassFieldExtractor(final int index,
                                            final Class fieldType,
                                            final ValueType valueType) {
        super( index,
               fieldType,
               valueType );
    }

    public BaseObjectClassFieldExtractor(final Class clazz,
                                         final String fieldName) {
        super( clazz,
               fieldName );
    }

    public abstract Object getValue(InternalWorkingMemory workingMemory, Object object);

    public boolean getBooleanValue(InternalWorkingMemory workingMemory, final Object object) {
        // this can be improved by generating specific 
        // bytecode generation in the subclass, avoiding the if instanceof
        final Object value = getValue( workingMemory, object );
        
        if ( value instanceof Boolean ) {
            return ((Boolean) value).booleanValue();
        }
        throw new RuntimeDroolsException( "Conversion to boolean not supported from " + value.getClass().getName() );
    }

    public byte getByteValue(InternalWorkingMemory workingMemory, final Object object) {
        // this can be improved by generating specific 
        // bytecode generation in the subclass, avoiding the if instanceof
        final Object value = getValue( workingMemory, object );
        
        if ( value instanceof Number ) {
            return ((Number) value).byteValue();
        }
        throw new RuntimeDroolsException( "Conversion to byte not supported from " + value.getClass().getName() );
    }

    public char getCharValue(InternalWorkingMemory workingMemory, final Object object) {
        // this can be improved by generating specific 
        // bytecode generation in the subclass, avoiding the if instanceof
        final Object value = getValue( workingMemory, object );
        
        if ( value instanceof Character ) {
            return ((Character) value).charValue();
        } else if( value instanceof String && ((String)value).length() == 1 ) {
            return ((String)value).charAt( 0 );
        }
        throw new RuntimeDroolsException( "Conversion to char not supported from " + value.getClass().getName() );
    }

    public double getDoubleValue(InternalWorkingMemory workingMemory, final Object object) {
        // this can be improved by generating specific 
        // bytecode generation in the subclass, avoiding the if instanceof
        final Object value = getValue( workingMemory, object );
        
        if ( value instanceof Number ) {
            return ((Number) value).doubleValue();
        }
        throw new RuntimeDroolsException( "Conversion to double not supported from " + value.getClass().getName() );
    }

    public float getFloatValue(InternalWorkingMemory workingMemory, final Object object) {
        // this can be improved by generating specific 
        // bytecode generation in the subclass, avoiding the if instanceof
        final Object value = getValue( workingMemory, object );
        
        if ( value instanceof Number ) {
            return ((Number) value).floatValue();
        }
        throw new RuntimeDroolsException( "Conversion to float not supported from " + value.getClass().getName() );
    }

    public int getIntValue(InternalWorkingMemory workingMemory, final Object object) {
        // this can be improved by generating specific 
        // bytecode generation in the subclass, avoiding the if instanceof
        final Object value = getValue( workingMemory, object );
        
        if ( value instanceof Number ) {
            return ((Number) value).intValue();
        }
        throw new RuntimeDroolsException( "Conversion to int not supported from " + value.getClass().getName() );
    }

    public long getLongValue(InternalWorkingMemory workingMemory, final Object object) {
        // this can be improved by generating specific 
        // bytecode generation in the subclass, avoiding the if instanceof
        final Object value = getValue( workingMemory, object );
        
        if ( value instanceof Number ) {
            return ((Number) value).longValue();
        }
        throw new RuntimeDroolsException( "Conversion to long not supported from " + value.getClass().getName() );
    }

    public short getShortValue(InternalWorkingMemory workingMemory, final Object object) {
        // this can be improved by generating specific 
        // bytecode generation in the subclass, avoiding the if instanceof
        final Object value = getValue( workingMemory, object );

        if ( value instanceof Number ) {
            return ((Number) value).shortValue();
        }
        throw new RuntimeDroolsException( "Conversion to short not supported from " + value.getClass().getName() );
    }
    
    public boolean isNullValue(InternalWorkingMemory workingMemory, final Object object) {
        if (object == null) {
            return true;
        } else {
            return getValue( workingMemory, object ) == null;
        }
    }

    public Method getNativeReadMethod() {
        try {
            return this.getClass().getDeclaredMethod( "getValue",
                                                      new Class[]{InternalWorkingMemory.class, Object.class} );
        } catch ( final Exception e ) {
            throw new RuntimeDroolsException( "This is a bug. Please report to development team: " + e.getMessage(),
                                              e );
        }
    }

    public int getHashCode(InternalWorkingMemory workingMemory, final Object object) {
        final Object value = getValue( workingMemory, object );
        return (value != null) ? value.hashCode() : 0;
    }

}
