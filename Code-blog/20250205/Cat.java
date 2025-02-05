class Cat
{
    String name;

    Cat(String name)
    {
        this.name = name;
    }

    public static void main(String[] args)
    {
        Cat cat1 = new Cat("tommy");
        cat1 = null;
    }

    protected void finalize() throws Throwable
    {
        System.out.println(name + "destroyed");
    }
}