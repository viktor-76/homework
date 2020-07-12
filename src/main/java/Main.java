import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Double usdAmount = 150.00;
        Double usdRate = 0.8924;
        System.out.println(usdAmount + " $ = " + getEurFromUsd(usdAmount, usdRate) + " €");

        Date date = new Date(120, 5, 28);
        System.out.println(date + " = " + getMsFromDate(date) + " ms");

        int hours = 2;
        int minutes = 10;
        System.out.println("За " + hours + ":" + minutes + " бега будет потрачено " + getCalories(hours, minutes) + " калорий");

        String text = "Harry Potter's life is miserable. His parents are dead and he's stuck with his heartless relatives, who force him to live in a tiny closet under the stairs. But his fortune changes when he receives a letter that tells him the truth about himself: he's a wizard. A mysterious visitor rescues him from his relatives and takes him to his new home, Hogwarts School of Witchcraft and Wizardry.After a lifetime of bottling up his magical powers, Harry finally feels like a normal kid. But even within the Wizarding community, he is special. He is the boy who lived: the only person to have ever survived a killing curse inflicted by the evil Lord Voldemort, who launched a brutal takeover of the Wizarding world, only to vanish after failing to kill Harry.Though Harry's first year at Hogwarts is the best of his life, not everything is perfect. There is a dangerous secret object hidden within the castle walls, and Harry believes it's his responsibility to prevent it from falling into evil hands. But doing so will bring him into contact with forces more terrifying than he ever could have imagined.Full of sympathetic characters, wildly imaginative situations, and countless exciting details, the first installment in the series assembles an unforgettable magical world and sets the stage for many high-stakes adventures to come. Mr. and Mrs. Dursley, of number four, Privet Drive, were proud to say that they were perfectly normal, thank you very much. They were the last people you'd expect to be involved in anything strange or mysterious, because they just didn't hold with such nonsense. Mr. Dursley was the director of a firm called Grunnings, which made drills. He was a big, beefy man with hardly any neck, although he did have a very large mustache. Mrs. Dursley was thin and blonde and had nearly twice the usual amount of neck, which came in very useful as she spent so much of her time craning over garden fences, spying on the neighbors. The Dursleys had a small son called Dudley and in their opinion there was no finer boy anywhere. The Dursleys had everything they wanted, but they also had a secret, and their greatest fear was that somebody would discover it. They didn't think they could bear it if anyone found out about the Potters. Mrs. Potter was Mrs. Dursley's sister, but they hadn't met for several years; in fact, Mrs. Dursley pretended she didn't have a sister, because her sister and her good-for-nothing husband were as unDursleyish as it was possible to be. The Dursleys shuddered to think what the neighbors would say if the Potters arrived in the street. The Dursleys knew that the Potters had a small son, too, but they had never even seen him. This boy was another good reason for keeping the Potters away; they didn't want Dudley mixing with a child like that. When Mr. and Mrs. Dursley woke up on the dull, gray Tuesday our story starts, there was nothing about the cloudy sky outside to suggest that strange and mysterious things would soon be happening all over the country. Mr. Dursley hummed as he picked out his most boring tie for work, and Mrs. Dursley gossiped away happily as she wrestled a screaming Dudley into his high chair. None of them noticed a large, tawny owl flutter past the window. At half past eight, Mr. Dursley picked up his briefcase, pecked Mrs. Dursley on the cheek, and tried to kiss Dudley good-bye but missed, because Dudley was now having a tantrum and throwing his cereal at the walls. \"Little tyke,\" chortled Mr. Dursley as he left the house. He got into his car and backed out of number four's drive. It was on the corner of the street that he noticed the first sign of something peculiar -- a cat reading a map. For a second, Mr. Dursley didn't realize what he had seen -- then he jerked his head around to look again. There was a tabby cat standing on the corner of Privet Drive, but there wasn't a map in sight. What could he have been thinking of? It must have been a trick of the light. Mr. Dursley blinked and stared at the cat. It stared back. As Mr. Dursley drove around the corner and up the road, he watched the cat in his mirror. It was now reading the sign that said Privet Drive -- no, looking at the sign; cats couldn't read maps or signs. Mr. Dursley gave himself a little shake and put the cat out of his mind. As he drove toward town he thought of nothing except a large order of drills he was hoping to get that day.";
        printUniqueWords(text);
    }

    // Написать метод, который переводит дату без времени в миллисекунды
    public static Long getMsFromDate(Date date) {
        return date.getTime();
    }

    // Написать метод, который переводит доллары в евро
    public static BigDecimal getEurFromUsd(Double amount, Double rate) {
        BigDecimal usd  = BigDecimal.valueOf(amount/rate);
        return usd.setScale(2, BigDecimal.ROUND_UP);
    }

    // Написать метод, который вычисляет калории, потраченные за определённое время бега
    public static int getCalories(int hours, int minutes) {
        return (hours*60 + minutes)*10;
    }

    // Посчитать и вывести в консоль количество уникальных слов (без учёта регистра), знаки препинания, тире и пр. убрать, вывести количество повторений слов
    public  static  void printUniqueWords(String text) {
        text = text.replaceAll(" - ", " ");
        // удаляем не пробелы, буквы и цифры
        text = text.replaceAll("[^\\w\\s-]", " ");
        // удаляем лишние пробелы
        text = text.replaceAll("  *", " ").toLowerCase();
        String[] words = text.split(" ");
        HashMap<String, Integer> bookUniqueWords = new HashMap<>();
        Integer wordCount = null;
        for (String word : words) {
            wordCount = 1;
            if (bookUniqueWords.containsKey(word)) {
                wordCount = bookUniqueWords.get(word) + 1;
            }
            bookUniqueWords.put(word, wordCount);
        }
        for (Map.Entry<String, Integer> entry : bookUniqueWords.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println(bookUniqueWords.size());
    }
}

