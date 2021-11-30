import java.math.BigInteger;

class DiffieHellman
{
    private PrimeNum primeNum = new PrimeNum();

    public DiffieHellman()
    {
        PrimeNumber = primeNum.GetPrimeNumber();
    }

    public int PrimeNumber;

    public BigInteger GetKey(int g, int p, int a)
    {
        return new BigInteger(Integer.toString(g)).modPow(new BigInteger(Integer.toString(a)), new BigInteger(Integer.toString(p)));
    }

    public String EncryptMessage(String message, BigInteger key)
    {
        String encryptedMessage = "";

        for (int i = 0; i < message.length(); i++) {
            encryptedMessage += (char)(message.charAt(i) + key.intValue());
        }

        return encryptedMessage;
    }

    public String DecryptMessage(String message, BigInteger key)
    {
        String decryptedMessage = "";

        for (int i = 0; i < message.length(); i++)
        {
            int cod = (int)(((int) message.charAt(i)) - key.intValue());

            decryptedMessage += (char) cod;
        }

        return decryptedMessage;
    }
}