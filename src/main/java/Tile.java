import com.sun.jdi.ClassNotPreparedException;

public class Tile implements Tilable{

    private Human human;
    private Infected infected;

    @Override
    public boolean isInteractionPossible(){
        return (human != null && infected != null);
    }

    @Override
    public boolean isInfectedFree(){
        return (infected == null);
    }

    @Override
    public boolean isHumanFree(){
        return (human == null);
    }

    @Override
    public boolean isFree(){
        return (human == null && infected == null);
    }

//    public void setCharacterable(Characterable characterable){
//        if(characterable instanceof Infected){
//            this.infected = (Infected)characterable;
//        }
//        else if(characterable instanceof Human){
//            this.human = (Human)characterable;
//        }
//        else{
//            throw new ClassNotPreparedException();
//        }
//    }


    @Override
    public Human getHuman(){
        return human;
    }

    @Override
    public Infected getInfected(){
        return infected;
    }

    @Override
    public void setHuman(Human human){
        this.human = human;
    }

    @Override
    public void setInfected(Infected infected){
        this.infected = infected;
    }

}
