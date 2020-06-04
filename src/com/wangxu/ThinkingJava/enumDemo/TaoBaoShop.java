package com.wangxu.ThinkingJava.enumDemo;

public class TaoBaoShop {
    enum CustomerService {
        ROBOT_SERVICE {
            boolean handle(Question question) {
                return question.qs[ROBOT_SERVICE.ordinal()];
            }
        },
        TEL_SERVICE {
            boolean handle(Question question) {
                return question.qs[TEL_SERVICE.ordinal()];
            }
        },
        TECHNICAL_SERVICE {
            boolean handle(Question question) {
                return question.qs[TECHNICAL_SERVICE.ordinal()];
            }
        };

        abstract boolean handle(Question question);
    }

    class Question {
        private boolean[] qs;

        public Question(boolean[] qs) {
            this.qs = qs;
        }
    }


    static String resolveQs(Question question) {
        for (CustomerService service : CustomerService.values()) {
            if (service.handle(question)) {
                return "Question has been resolved by:" + service.name();
            }
        }
        return "resolve Question failed";
    }

    public static void main(String[] args) {
        TaoBaoShop shop = new TaoBaoShop();
        Question qs = shop.new Question(new boolean[]{false, false, true});
        String result = resolveQs(qs);
        System.out.println(result);
    }
}
