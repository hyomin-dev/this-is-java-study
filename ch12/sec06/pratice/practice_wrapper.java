package ch12.sec06.pratice;

public class practice_wrapper {
    public static void main(String[] args) {
        boolean primitive_boolean = true;
        char primitive_char = 'C';
        byte primitive_byte = 11;
        short primitve_short = 11;
        int primitive_int = 11;
        long primitive_long = 11L;
        float primitive_float = 3.3f;
        double primitive_double = 3.3;


        // primitive type을 Wrapper object로 변환 ===> WrapperClass.valueOf(primitiveType)

        Boolean wrapper_Boolean = Boolean.valueOf(primitive_boolean);
        Character wrapper_Character = Character.valueOf(primitive_char);
        Byte wrapper_Byte = Byte.valueOf(primitive_byte);
        Short wrapper_Short = Short.valueOf(primitve_short);
        Integer wrapper_Integer = Integer.valueOf(primitive_int);
        Long wrapper_Long = Long.valueOf(primitive_long);
        Float wrapper_Float = Float.valueOf(primitive_float);
        Double wrapper_Double = Double.valueOf(primitive_double);


        //Wrapper object를 primitive type으로 변환 ===>wrapperObj.primitiveTypeValue()

        primitive_boolean = wrapper_Boolean.booleanValue();
        primitive_char = wrapper_Character.charValue();
        primitive_byte = wrapper_Byte.byteValue();
        primitve_short = wrapper_Short.shortValue();
        primitive_int = wrapper_Integer.intValue();
        primitive_long = wrapper_Long.longValue();
        primitive_float = wrapper_Float.floatValue();
        primitive_double = wrapper_Double.doubleValue();

        //primitive type을 문자열로 변환 ===> String.valueOf(primitive type)
        String string_boolean = String.valueOf(primitive_boolean);
        String string_char = String.valueOf(primitive_char);
        String string_byte = String.valueOf(primitive_byte);
        String string_short = String.valueOf(primitve_short);
        String string_int = String.valueOf(primitive_int);
        String string_long = String.valueOf(primitive_long);
        String string_float = String.valueOf(primitive_float);
        String string_double = String.valueOf(primitive_double);


        //문자열을 primitive type으로 변환 ===> WrapperClass.parseWrapperClass(String)

        primitive_boolean = Boolean.parseBoolean(string_boolean);
        primitive_char = string_char.charAt(0);
        primitive_byte = Byte.parseByte(string_byte);
        primitve_short = Short.parseShort(string_short);
        primitive_int = Integer.parseInt(string_int);
        primitive_long = Long.parseLong(string_long);
        primitive_float = Float.parseFloat(string_float);
        primitive_double = Double.parseDouble(string_double);










    }
}
