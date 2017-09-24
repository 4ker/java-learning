package com.brianway.learning.java.base.generics;

import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;
import jdk.nashorn.internal.objects.annotations.Constructor;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class GenericDao<T>{
    public void add(T x){
    }

    public T findById(int id){
        return null;
    }

    public void delete(T obj){
    }

    public void delete(int id){
    }

    public void update(T obj){
    }

    public T findByUserName(String name){
        return null;
    }

    public static <T> Set<T> findByConditions(String where){
        return null;
    }

    public static <T,T2> Set<T> findByConditions(T2 where){
        return null;
    }

    public static void main(String[] args) {
        GenericDao<Integer> dao = new GenericDao<Integer>();
        Set<Double> cond = GenericDao.findByConditions(0.3);

        if(new int[5] instanceof Object) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }


    }

    public static class GenericTest {

        /*利用反射获取方法参数的实际参数类型*/
        public static void getParamType() throws NoSuchMethodException{
            Method method = GenericTest.class.getMethod("applyMap", Map.class);
            //获取方法的泛型参数的类型
            Type[] types = method.getGenericParameterTypes();
            System.out.println(types[0]);
            //参数化的类型
            ParameterizedType pType  = (ParameterizedType)types[0];
            //原始类型
            System.out.println(pType.getRawType());
            //实际类型参数
            System.out.println(pType.getActualTypeArguments()[0]);
            System.out.println(pType.getActualTypeArguments()[1]);
            Class clazz = GenericTest.class;
            clazz.getDeclaredMethods();
            clazz.getMethods();

            java.lang.reflect.Constructor[] constructors = clazz.getConstructors();
        }

        /*供测试参数类型的方法*/
        public static void applyMap(Map<Integer,String> map){

        }

    }

}
