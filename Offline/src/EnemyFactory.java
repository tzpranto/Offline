
public class EnemyFactory {
	public EnemyShip enemyMaker(String type)
	{
		if(type.equals("U"))
		{
			return new UFOEnemyShip();
		}
		else if(type.equals("R"))
		{
			return new RocketEnemyShip();
		}
		else if(type.equals("B"))
		{
			return new BigUFOEnemyShip();
		}
		return null;
	}

}
