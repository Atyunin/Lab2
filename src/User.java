import java.math.BigInteger;

class User
{
    private DiffieHellman diffieHellman = new DiffieHellman();
    private int generator;
    private String message;
    public String name;
    private int primemodulus;

    private BigInteger secret;
    public int public_key;


    public User(String name, int generator, int primemodulus, String message)
    {
        this.name = name;
        this.primemodulus = primemodulus;
        this.message = message;
        this.generator = generator;
        public_key = diffieHellman.PrimeNumber;
        secret = diffieHellman.GetKey(this.generator, this.primemodulus, public_key);
    }

    public User(String name, int generator, int primemodulus) {

        this(name, generator, primemodulus, "");
    }

    public BigInteger GetKey(int public_key)
    {
        BigInteger g = secret.pow(public_key);
        BigInteger Chave = g.mod(new BigInteger(Integer.toString(primemodulus)));

        return Chave;
    }

    public String SendMessage(BigInteger key)
    {
        String encryptedMessage = diffieHellman.EncryptMessage(message, key);

        return encryptedMessage;
    }

    public String GetMessage(String message, BigInteger key)
    {
        String decryptedMessage = diffieHellman.DecryptMessage(message, key);

        return decryptedMessage;
    }
}