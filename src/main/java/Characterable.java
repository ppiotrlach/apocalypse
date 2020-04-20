public interface Characterable {

    void setHealthPoints(double healhPoints);
    double getHealPoints();

    void setAttackDamage(double attackDamage);
    double getAttackDamage();

    void setIsInfected(boolean isInfected);
    boolean getIsInfected();

    void setLocation(int x, int y);
    int getXCoordinate();
    int getYCoordinate();

    void moveX(int x);
    void moveY(int y);

    void setViewRange(int viewRange);
    int getViewRange();

    void setIsAlive(boolean isAlive);
    boolean getIsAlive();

    boolean isInTheSameLocation(Character character2);



}
