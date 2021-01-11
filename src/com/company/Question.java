package com.company;

import java.util.Arrays;

public class Question {
    private String title;
    private String answer;
    private char[] mas;

    public Question(String title, String answer) {
        this.title = title;
        this.answer = answer;
        mas = new char[answer.length()];
        for (int i = 0; i < mas.length; i++){
            mas[i] = '*';
        }
    }

    public void printMas(){
        System.out.print("Слово: ");
        for (char i: mas) {
            System.out.print(i);
        }
        System.out.println();
    }
    
    public boolean Check (String ans, User user){ //если есть жизни
        if (ans.length() == 1){
            boolean isInside = false;
            for (int i = 0; i < answer.length(); i++){
                if (ans.charAt(0) == answer.charAt(i)){
                    if(mas[i] == answer.charAt(i)){
                        System.out.println("Вы уже назвали эту букву, введите другую.");
                        return false;
                    }
                    else{
                        isInside = true;
                        mas[i] = answer.charAt(i);
                    }
                }
            }
            if (isInside){
                System.out.println("Да, есть такая буква. Откройте ее!");
                printMas();
                if (Arrays.equals(answer.toCharArray(), mas)){
                    System.out.println("Поздравляю вы разгадали слово. Вы получайте 3 жизни и возможность разгадать следующее слово.");
                    user.addHealth(3);
                    return true;
                }
                return false;
            }
            else{
                System.out.println("К сожалению такой буквы нет. Мы вынуждены отобрать у вас 1 жизнь.");
                user.addHealth(-1);
                return false;
            }
        }
        else{
            if (ans.equals(answer)){
                System.out.println("Верно! Прямо в точку! Вы получайте 3 жизни и возможность разгадать следующее слово.");
                user.addHealth(3);
                return true;
            }
            System.out.println("К сожалению это неверное слово. Мы вынуждены отобрать у вас 1 жизнь. Попробуйте назвать букву.");
            user.addHealth(-1);
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
