
public abstract class EnemyShip {
	private String name;
	private double damage;
	public void setName(String s)
	{
		name = s;
	}
	public void setDamage(double d)
	{
		damage = d;
	}
	public String getName()
	{
		return name;
	}
	public double getDamage()
	{
		return damage;
	}
	public void follow()
	{
		System.out.println(getName()+" is following Hero");
	}
	public void display()
	{
		System.out.println(getName()+" is on the screen");
	}
	public void attack()
	{
		System.out.println(getName()+" attacks and does "+getDamage()+" damage");
	}	

}
