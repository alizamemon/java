package bicycle;

public interface BiCycle { 
void Speed(int a); 
void ApplyBrake(int a); 
void ChangeGear(int a);
default void cadenceRate(){
    System.out.println("cadence is 120");
}
}
 

