public class MonsterFactory {

    public static Ogre createOgre() {
        return new Ogre();
    }

    public static Gremlin createGremlin() {
        return new Gremlin();
    }

    public static Skeleton createSkeleton() {
        return new Skeleton();
    }

    public static Zombie createZombie() { return new Zombie();}

    public static Bat createBat() { return new Bat(); }

}