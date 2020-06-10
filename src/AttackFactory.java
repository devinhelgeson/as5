public class AttackFactory {

    //This is our flyweight pool.
    private static Club club = null;
    private static FireBallSpell fbs = null;
    private static Kris kris = null;
    private static RegularAttack attack = null;
    private static RustyBlade blade = null;
    private static Sword sword = null;
    private static Fang fang = null;
    private static GolfClub gc = null;

    public static Club ClubFactory() {
        if (club == null) club = new Club();
        return club;
    }

    public static FireBallSpell FireBallSpellFactory() {
        if (fbs == null) fbs = new FireBallSpell();
        return fbs;
    }

    public static Kris KrisFactory() {
        if(kris == null) kris = new Kris();
        return kris;
    }

    public static RegularAttack RegularAttackFactory() {
        if(attack == null) attack = new RegularAttack();
        return attack;
    }

    public static RustyBlade RustyBladeFactory() {
        if(blade == null) blade = new RustyBlade();
        return blade;
    }

    public static Sword SwordFactory() {
        if(blade == null) sword = new Sword();
        return sword;
    }

    public static Fang FangFactory() {
        if(fang == null) fang = new Fang();
        return fang;
    }

    public static GolfClub GolfClubFactory() {
        if(gc == null) gc = new GolfClub();
        return gc;
    }

}
