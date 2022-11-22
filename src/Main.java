public class Main {
    public static void main(String[] args) {
        String s = "нЕптун ";
        String kw = "шифрОвка";
        System.out.println("Исходная строка: " + s);
        System.out.println("Зашифрованная строка: " + (s = CaesarCipherWithKeyword.encode(s, 3, kw)));
        System.out.println("Дешифрованная строка: " + (s = CaesarCipherWithKeyword.decode(s, 3, kw)));
    }
}
