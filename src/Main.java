import java.math.BigInteger;

class Main
{

    public static void main(String[] args)
    {
        PrimeNum primeNum = new PrimeNum();

        String message = TextDriver.ReadText("messages/Input.txt");

        int generator = primeNum.GetPrimeNumber();
        int primemodulus = primeNum.GetPrimeNumber();

        User alice = new User("Alice", generator, primemodulus, message);
        User bob = new User("Bob", generator, primemodulus);

        BigInteger keyAlice = alice.GetKey(bob.prime);
        BigInteger keyBob = bob.GetKey(alice.prime);

        System.out.println("Ключ Алисы: " + keyAlice + " Ключ Боба: " + keyBob);

        String encrypteMessage = alice.SendMessage(keyAlice);

        TextDriver.WriteText("messages/Encode.txt", encrypteMessage);

        String decryptedMessage = bob.GetMessage(encrypteMessage, keyBob);

        TextDriver.WriteText("messages/Decode.txt", decryptedMessage);
    }
}