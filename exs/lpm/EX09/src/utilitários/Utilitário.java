package utilitários;

import java.security.SecureRandom;
import java.util.Random;

public class Utilitário {
    public static void gerador() {
        String[] livros = {
                "Introduction to Algorithms",
                "The Art of Computer Programming",
                "Compilers",
                "The Design and Evolution of C++",
                "Object Oriented Analysis and Design",
                "The Unified Software Development Process",
                "UML Distilled",
                "Refactoring",
                "Agile",
                "Extreme Programming Explained",
                "Clean Code",
                "The Clean Coder",
                "The Pragmatic Programmer",
                "Design Patterns",
                "Patterns of Enterprise Application Patterns",
                "Domain Driven Design",
                "The Lean Startup",
                "The Mythical Man-Month",
                "Hobbit ",
                "O Senhor dos Anéis",
                "O Silmarillion",
                "Contos Inacabados",
                "As Aventuras de Tom Bombadil",
                "Os Filhos de Húrin",
                "The history of Middle-earth: The Book of Lost Tales Part I",
                "The history of Middle-earth: The Book of Lost Tales Part II",
                "The history of Middle-earth: The Lays of Beleriand",
                "The history of Middle-earth: The Shaping of Middle-earth",
                "The history of Middle-earth: The Lost Road and Other Writings",
                "The history of Middle-earth: The Return of the Shadow",
                "The history of Middle-earth: The Treason of Isengard",
                "The history of Middle-earth: The War of the Ring",
                "The history of Middle-earth: Sauron Defeated",
                "The history of Middle-earth: Morgoth’s Ring",
                "The history of Middle-earth: The War of the Jewels",
                "The history of Middle-earth: The People’s of Middle-earth",
                "The History of Middle-earth Index",
                "Beowulf (tradução comentada)",
                "Sir Gawain and the Green Knight (tradução)",
                "Finn and Hengest (estudo)",
                "The Monsters and the Critics (ensaio)",
                "Tolkien On Fairy-stories (expanded edition)",
                "Mestre Gil de Ham",
                "Cartas do Papai Noel ",
                "Roverandom (ed. Brasileira)",
                "Ferreiro de Bosque Grande",
                "A Lenda de Sigurd & Gudrún",
                "A Queda de Artur",
                "A História de Kullervo",
                "Sr. Bliss",
                "A Última Canção de Bilbo ",
                "Poemas de O Senhor dos Anéis",
                "J. R. R. Tolkien Artist & Illustrator",
                "The Art of The Hobbit",
                "The Art of The Lord of the Rings",
                "Beren and Lúthien",
                "The Lay of Aotrou & Itroun",
                "As Cartas de J. R. R. Tolkien",
        };

        String[] nomes = {
                "Costello",
                "Kid Richards",
                "Party Poison",
                "Morrison",
                "Matt Davu",
                "Mumford",
                "Jimmy",
                "Bowie",
                "Monkey",
                "Manson",
                "Dianury",
                "John Beacon",
                "Korne",
                "Blood Sandwich",
                "Alice",
                "Blackout",
                "Ramone",
                "Cohen",
                "Iggy",
                "Primal Scream",
                "Monolith",
                "Gojira",
                "Smoke and Mirrors",
                "Ringo",
                "Rile Nodger",
                "Springstone",
                "Turner",
                "Bowie",
                "Metalic",

        };

        /*
         * for (int i = 0; i < livros.length; i++) {
         * System.out.println(gerarCodigo(8) + ";" + livros[i]);
         * }
         */
        for (int i = 0; i < nomes.length; i++) {
            System.out.println(gerarCodigo(6) + ";" + nomes[i]);
        }

    }
    public static String gerarCodigo(int length) {
        char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random random = new SecureRandom();
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            int randomCharIndex = random.nextInt(characterSet.length);
            result[i] = characterSet[randomCharIndex];
        }
        return new String(result);
    }
}
