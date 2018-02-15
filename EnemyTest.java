package koulu2;
import java.util.Scanner;

public class EnemyTest {

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int damage;
		int ap;

		Enemy ork = new Enemy();

		System.out.println("Enter damage");
		damage = input.nextInt();
		System.out.println("Enter AP");
		ap = input.nextInt();

		// call method subWounds
		ork.subWounds(damage);
		System.out.print(ork.getWounds());
	}
}


