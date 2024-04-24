package bicycle;
 public class MyBiCycle implements BiCycle {
 double speed;
 int gear;
 double cadence;

 public MyBiCycle(double speed, int gear,double cadence) {
 this.speed = speed; 
 this.gear = gear; 
 this.cadence=cadence;
} 
public void Speed(int a){
 speed+=a; } 
public void ApplyBrake(int a){
 speed-=a; }
 public void ChangeGear(int a){ 
gear=a; } 
public String toString(){ 
    return "BiCycle Speed= "+speed+"\nBiCycle is on Gear= "+gear+"\nwith cadence rate"+cadence;	
}
public void CadenceRate(int a){
 cadence+=a;
} 
 }