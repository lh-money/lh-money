package com.lh.money.mode.factory;

/**
 * @author lihao
 */
public class FactoryDesignPattern {


    /**
     * 简单工厂模式 创建抽象接口、具体产品实现抽象产品 比较鸡肋，每一种抽象产品和具体产品都需要创建相对应的类 适合较少产品这种场景项目里使用
     **/
    //抽象产品
    public interface Product {

        void show();
    }

    //具体产品：ProductA
    static class ConcreteProduct1 implements Product {

        @Override
        public void show() {
            System.out.println("具体产品1显示...");
        }
    }

    //具体产品：ProductB
    static class ConcreteProduct2 implements Product {

        @Override
        public void show() {
            System.out.println("具体产品2显示...");
        }
    }

    final class Const {

        static final int PRODUCT_A = 0;
        static final int PRODUCT_B = 1;
    }

    static class SimpleFactory {

        public static Product makeProduct(int kind) {
            switch (kind) {
                case Const.PRODUCT_A:
                    return new ConcreteProduct1();
                case Const.PRODUCT_B:
                    return new ConcreteProduct2();
            }
            return null;
        }
    }

}

/**
 * 工厂方法模式
 * 具体产品实现抽象产品
 * 具体工厂调用不同的具体产品并生产出来
 * 工厂生产具体产品可由xml进行配置达到外部配置工厂生产具体产品的功能
 * 使用搭配具体场景
 **/

//抽象产品：提供了产品的接口
interface Product {
    public void show();
}
//具体产品1：实现抽象产品中的抽象方法
class ConcreteProduct1 implements Product {
    @Override
    public void show() {
        System.out.println("具体产品1显示...");
    }
}
//具体产品2：实现抽象产品中的抽象方法
class ConcreteProduct2 implements Product {
    @Override
    public void show() {
        System.out.println("具体产品2显示...");
    }
}
//抽象工厂：提供了厂品的生成方法
interface AbstractFactory {
    public Product newProduct();
}
//具体工厂1：实现了厂品的生成方法
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}
//具体工厂2：实现了厂品的生成方法
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product newProduct() {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}

