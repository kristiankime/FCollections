package com.artclod.common;

import static org.junit.Assert.assertEquals;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

public abstract class SerializeDeserialize {
    
    @SuppressWarnings("unchecked")
	public static <T extends Serializable> void serializeDeserializeEqual(T object) {
    	byte[] serialized = SerializationUtils.serialize(object);
		T deserialized = (T) SerializationUtils.deserialize(serialized);
		assertEquals(object, deserialized);
    }
	
}