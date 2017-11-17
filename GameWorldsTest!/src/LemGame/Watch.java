package LemGame;
public class Watch {
    
    private long mStartTime;
    private long mEndTime;
    private long mElapsedPause;
    private int mLastSecond = 0;

    private boolean mIsOn;
    private boolean mIsPaused;

    private int mSeconds;
    private int mMinutes;

    public Watch() {
        mStartTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return mStartTime;
    }

    public long getEndTime() {
        return mEndTime;
    }

    public void start() {
        mIsOn = true;
        mStartTime = System.currentTimeMillis();
    }

    public void stop(){
        mEndTime = System.currentTimeMillis();
        mIsOn = false;
    }

    public long getElapsedTime() {
        return mEndTime - mStartTime;
    }

    public long peek() {
        return System.currentTimeMillis() - mStartTime;
    }
    public void pause() {
        mIsPaused = true;
        mElapsedPause = System.currentTimeMillis() - mStartTime;
    }

    public void resume() {
        mIsPaused = false;
        mStartTime = System.currentTimeMillis() - mElapsedPause;
    }

    public boolean isOn() {
        return mIsOn;
    }

    public int getMinute(){
        updateTime();
        return mMinutes;
    }

    public int getSeconds(){
        updateTime();
        return mSeconds;
    }

    private void updateTime() {

        long currentTime = peek() / 1000;
        mSeconds = (int)(currentTime % 60);
        currentTime = currentTime / 60;

        mMinutes = (int) (currentTime % 60);
        currentTime = currentTime / 60;
    }

    public void reset(){
        stop();
        mMinutes = 0;
        mSeconds = 0;
        mStartTime = 0;
        mEndTime = 0;
    }
    public boolean isPaused() {
        return mIsPaused;
    }
    
}
