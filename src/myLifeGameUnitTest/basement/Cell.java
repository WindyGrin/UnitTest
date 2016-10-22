package myLifeGameUnitTest.basement;

/**
 * 细胞类，包括当前存活状态以及下一刻的存活状态
 */
public class Cell {

    private boolean AliveNow;
    private boolean AliveNext;

    public boolean isAliveNow() {
        return AliveNow;
    }

    public boolean isAliveNext() {
        return AliveNext;
    }

    public void setAliveNow(boolean aliveNow) {
        AliveNow = aliveNow;
    }

    public void setAliveNext(boolean aliveNext) {
        AliveNext = aliveNext;
    }

    public boolean getAliveNow() {
        return AliveNow;
    }

    public boolean getAliveNext() {
        return AliveNext;
    }

    public void timePass(){
        AliveNow = AliveNext;
    }

    public void aliveNextReady(int count){

        switch (count){
            case 2:
                break;
            case 3:
                setAliveNext(true);
                break;
            default:
                setAliveNext(false);
        }
    }
}