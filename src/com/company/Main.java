package com.company;

import java.util.*;

public class Main {

    public static User getUserProfile(String s) throws UserException{
        String[] ans = s.split(" ");
        if (Integer.parseInt(ans[1]) > 0 && Integer.parseInt(ans[1]) < 120){
            return new User(ans[0], Integer.parseInt(ans[1]));
        }
        else{
            throw new UserException("Возраст не входит в человеческие рамки");
        }
    }

    public static void main(String[] args) {
        Random random = new Random();

        ArrayList<Question> questionArrayList = new ArrayList<Question>();
        questionArrayList.add(new Question("Так в старину называли сторожа городских ворот.", "вратарь"));
        questionArrayList.add(new Question("Что мексиканцы изготовляли из волокнистой древесины кактусов?", "воротник"));
        questionArrayList.add(new Question("Какое животное дало название распространенному в Древнем Риме способу боевого построения?", "черепаха"));
        questionArrayList.add(new Question("У данного животоного него есть клюв и ядовитый шип.", "утконос"));
        questionArrayList.add(new Question("Птица, доставляющая особо ценные бандероли.", "аист"));
        questionArrayList.add(new Question("Персоонаж из сказки, который был \"доктором кукольных наук\".", "карабас"));
        questionArrayList.add(new Question("Отгадай загадку: \"Бежали овечки по калинову мосту: увидели зорюдакинулись в воду\".", "пельмени"));
        questionArrayList.add(new Question("Если убрать из этого предмета одежды 2 буквы, то получится музыкальный смычковый инструмент.", "пальто"));
        questionArrayList.add(new Question("С 1721 года высшее церковное учреждение в Русской Православной Церкви, а после 1917 года совещательный орган при Патриархе Московском и всея Руси.", "синод"));
        questionArrayList.add(new Question("Ради этого можно съесть много всего другого.", "десерт"));

        User user;
        Scanner scan = new Scanner(System.in);
        System.out.println("Приветствую! Представьтесь (имя возраст)"); //Тут вставить свое исключение
        try{
            user = getUserProfile(scan.nextLine());
        }
        catch (Exception e){
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Ваше имя и возраст установлены по умолчанию (имя: User, возраст: 30)");
            user = new User("User", 30);
        }

        System.out.println("Чтож, " + user.getName() + ", сегодня Вы примите участие в развлекательном квесте по типу игр \"Виселица\" и \"Поле чудес\".");
        System.out.println("Правила просты: Вам будет даваться подсказка, а Ваша задача угадать слово по этой подсказке," +
                " называя буквы этого слова (либо назвав слово сразу). За каждое угаданное слово вам дается 3 дополнительные жизни," +
                " но при допущении ошибки у вас забирается 1 жизнь. В начале игры у вас 5 жизней. ");
        System.out.println("Итак приступим:");
        int i;
        Question quest;
        while (questionArrayList.size() > 0){
            i = random.nextInt(questionArrayList.size());
            quest = questionArrayList.get(i);
            System.out.println(quest.getTitle() + " (" + quest.getAnswer().length() + " букв(а/ы))");
            quest.printMas();
            boolean isSolved = false;
            do{
                System.out.println("Ваше количесто жизней составляет: " + user.getHealth());
                isSolved = quest.Check(scan.nextLine().toLowerCase(), user);
            }
            while(!isSolved && user.getHealth() > 0);
            if (user.getHealth() == 0) {
                System.out.println("К сожалению, у Вас закончились жизни, игра окончена.");
                return;
            }
            questionArrayList.remove(i);
        }
        System.out.println("Поздравляю, Вы победили! Спасибо за игру, до встречи.");
    }
}
