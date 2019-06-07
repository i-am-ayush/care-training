package FormPopulator;


import form.Form;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormPopulator {
    private final static Logger logger = Logger.getLogger(FormPopulator.class);

    public static <T extends Form> T populate(HttpServletRequest request, Class<T> tClass) {

        try {
            return populateForm(request, tClass);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    public static <T extends Form> T populateFromDatabase(HttpServletRequest request, Class<T> tClass) {

        try {
            return populateFormFromDatabase(request, tClass);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
    public static <T extends Form> T populateFrom(HttpServletRequest request, Class<T> tClass) {

        try {
            return populateFormFrom(request, tClass);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
    public static <T extends Form> T populateFormFrom(HttpServletRequest request, Class<T> tClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        Method[] methods = tClass.getMethods();
        Class<?>[] typeList;
        T t = tClass.newInstance();
        for (Method method : methods) {
            String methodName=setterTest(method.getName());
            if (methodName!=null) {
                typeList = method.getParameterTypes();
                if (typeList[0].getName().equals("int")) {
                    method.invoke(t, Integer.parseInt(request.getParameter(methodName.substring(3))));
                } else if (typeList[0].getName().equals("double")) {
                    method.invoke(t, Double.parseDouble(request.getParameter(methodName.substring(3))));
                } else if (typeList[0].getName().substring(10).equals("Date")) {
                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    Date date = simpleDateFormat.parse(request.getParameter(methodName.substring(3)));
                    method.invoke(t, date);
                } else {
                    method.invoke(t, request.getParameter(methodName.substring(3)));
                }
            }
        }
        return t;
    }


    public static <T extends Form> T populateForm(HttpServletRequest request, Class<T> tClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        Field[] variables = tClass.getDeclaredFields();
        T t = tClass.newInstance();
        for (Field f : variables) {
            System.out.println(f.getType());
            Method fieldSetter = null;
            fieldSetter = tClass.getMethod(setterMethodName(f), f.getType());
            if (f.getType() == int.class) {
                System.out.println("int1");
                int i = Integer.parseInt(request.getParameter(f.getName()));
                fieldSetter.invoke(t, i);
                System.out.println("int");
            } else if (f.getType() == Date.class) {
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Date date = simpleDateFormat.parse(request.getParameter(f.getName()));
                fieldSetter.invoke(t, date);
                System.out.println(date);
            } else if (f.getType() == double.class) {
                System.out.println("int2");
                fieldSetter.invoke(t, Double.parseDouble(request.getParameter(f.getName())));
                System.out.println("double");
            }
//            else if(f.getType()==Enum.class) {
//
//                if(request.getParameter(f.getName()).equals("seeker"))
//                fieldSetter.invoke(t, Member.MemberType.SEEKER);
//                else
//                    fieldSetter.invoke(t, Member.MemberType.SITTER);
//
//
//            }

            else {
                System.out.println("int3");
                fieldSetter.invoke(t, request.getParameter(f.getName()));
                System.out.println("string");
            }

        }
        return t;
    }

    public static <T extends Form> T populateFormFromDatabase(HttpServletRequest request, Class<T> tClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ParseException {
        Field[] variables = tClass.getDeclaredFields();
        T t = tClass.newInstance();
        for (Field f : variables) {
            System.out.println(f.getType());
            Method fieldSetter = null;
            fieldSetter = tClass.getMethod(setterMethodName(f), f.getType());
            if (f.getType() == int.class) {
                System.out.println("int1");
                int i = Integer.parseInt(String.valueOf(request.getAttribute(f.getName())));
                fieldSetter.invoke(t, i);
                System.out.println("int");
            } else if (f.getType() == Date.class) {
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Date date = simpleDateFormat.parse(String.valueOf(request.getAttribute(f.getName())));
                fieldSetter.invoke(t, date);
                System.out.println(date);
            } else if (f.getType() == double.class) {
                System.out.println("int2");
                fieldSetter.invoke(t, Double.parseDouble(String.valueOf(request.getAttribute(f.getName()))));
                System.out.println("double");
            }
//            else if(f.getType()==Enum.class) {
//
//                if(request.getParameter(f.getName()).equals("seeker"))
//                fieldSetter.invoke(t, Member.MemberType.SEEKER);
//                else
//                    fieldSetter.invoke(t, Member.MemberType.SITTER);
//
//
//            }

            else {
                System.out.println("int3");
                fieldSetter.invoke(t, request.getAttribute(f.getName()));
                System.out.println("string");
            }

        }
        return t;
    }

    public static String setterTest(String s) {
        String name=null;
        if(s.substring(0, 3).equals("set")){
            name = s.substring(0, 3)+s.substring(3,4).toLowerCase() +s.substring(4);
        }
        return name;
    }

    private static String setterMethodName(Field f) {
        String name = f.getName();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        System.out.println("2");
        System.out.println(name);
        return "set" + name;
    }
}
