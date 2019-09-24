package frcsplines;

/**
 * A PID controller is a control feedback loop used in control systems.
 */
public class PID {

    private double kp, ki, kd;

    private double lastError;
    private double lastTime;
    private double integral;

    /**
     * create a new PID loop object
     * @param kp
     * @param ki
     * @param kd
     */
    public PID(double kp, double ki, double kd){
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
    }

    /**
     * update the pid with data and get the fix value
     * @param time current system time
     * @param currentValue current system point
     * @param target current system Set point
     * @return the fix value
     */
    public double update(double time, double currentValue, double target){
        double error = target - currentValue;

        double p = error;
        double d = 0;
        if(time - lastTime != 0 ) {
            d = (error - lastError)/(time - lastTime);
        }
        integral += (error + lastError)*(time-lastTime)/2;

        lastTime = time;
        lastError = error;

        return kp*p + ki*integral + kd*d;
    }
}