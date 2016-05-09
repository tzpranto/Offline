import java.util.*;
public class Offline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner (System.in);
		EnemyShip newShip = null;
		EnemyFactory newEnemy = new EnemyFactory();
		System.out.println("Choose Enemy : U/R/B");
		if(s.hasNext())
		{
			String type = s.nextLine();
			newShip = newEnemy.enemyMaker(type);
		}
		if(newShip != null)
		{
			doStuff(newShip);
		}
		else
		{
			System.out.println("Next time choose U/R/B");
		}

	}
	public static void doStuff(EnemyShip ob)
	{
		ob.follow();
		ob.display();
		ob.attack();
	}

}
