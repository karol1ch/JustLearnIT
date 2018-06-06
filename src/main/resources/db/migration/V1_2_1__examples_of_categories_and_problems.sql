INSERT INTO public.category (name, description) VALUES ('Java', 'The worst programming language ever made. Java was created as an example of how not to do programming languages.');
INSERT INTO public.category (name, description) VALUES ('C++', 'Language made as an alternative to C. The main assumption of the creator was to make the language more difficult than anything else.');
INSERT INTO public.category (name, description) VALUES ('C#', 'Language made by Microsoft. It is everything you need to know about this language.');
INSERT INTO public.category (name, description) VALUES ('SQL', 'In this course you will learn basics of SQL.');
INSERT INTO public.category (name, description) VALUES ('Perl', 'PERL is abrbreviation of "Pathologically Eclectic Rubbish Lister", but some people say that the proper name is "Practical Extraction and Report Language".');
INSERT INTO public.category (name, description) VALUES ('Assembler', 'I am sure that you will never choose this category.');
INSERT INTO public.category (name, description) VALUES ('Algorithmics', 'The most important category on this page. In this course you will learn data structures and algorithms for solving problems in daily programming.');

INSERT INTO public.problem (id, name, author, content, category_name, input_description, output_description, number_of_accepted_solutions, difficulty, practice) VALUES (3, 'Liczby Pierwsze', 'marcin', 'Given the number, you are to answer the question: "Is it prime?"', 'Algorithmics', 't – the number of test cases, then t test cases follows. [t <= 500]
Each line contains one integer: N [2 <= N <= 100000000]', 'For each test case output string "YES" if given number is prime and "NO" otherwise.', 1324, 'easy', true);
INSERT INTO public.problem (id, name, author, content, category_name, input_description, output_description, number_of_accepted_solutions, difficulty, practice) VALUES (4, 'Factorial', 'dawid', 'The most important part of a GSM network is so called Base Transceiver Station (BTS). These transceivers form the areas called cells (this term gave the name to the cellular phone) and every phone connects to the BTS with the strongest signal (in a little simplified view). Of course, BTSes need some attention and technicians need to check their function periodically.

ACM technicians faced a very interesting problem recently. Given a set of BTSes to visit, they needed to find the shortest path to visit all of the given points and return back to the central company building. Programmers have spent several months studying this problem but with no results. They were unable to find the solution fast enough. After a long time, one of the programmers found this problem in a conference article. Unfortunately, he found that the problem is so called "Travelling Salesman Problem" and it is very hard to solve. If we have N BTSes to be visited, we can visit them in any order, giving us N! possibilities to examine. The function expressing that number is called factorial and can be computed as a product 1.2.3.4....N. The number is very high even for a relatively small N.

The programmers understood they had no chance to solve the problem. But because they have already received the research grant from the government, they needed to continue with their studies and produce at least some results. So they started to study behaviour of the factorial function.

For example, they defined the function Z. For any positive integer N, Z(N) is the number of zeros at the end of the decimal form of number N!. They noticed that this function never decreases. If we have two numbers N1 < N2, then Z(N1) <= Z(N2). It is because we can never "lose" any trailing zero by multiplying by any positive number. We can only get new and new zeros. The function Z is very interesting, so we need a computer program that can determine its value efficiently.', 'Algorithmics', 'There is a single positive integer T on the first line of input (equal to about 100000). It stands for the number of numbers to follow. Then there are T lines, each containing exactly one positive integer number N, 1 <= N <= 1000000000.', 'For every number N, output a single line containing the single non-negative integer Z(N).', 23, 'medium', true);
INSERT INTO public.problem (id, name, author, content, category_name, input_description, output_description, number_of_accepted_solutions, difficulty, practice) VALUES (5, 'Transform the Expression To RPN', 'szymon', 'Transform the algebraic expression with brackets into RPN form (Reverse Polish Notation). Two-argument operators: +, -, *, /, ^ (priority from the lowest to the highest), brackets ( ). Operands: only letters: a,b,...,z. Assume that there is only one RPN form (no expressions like a*b*c).', 'Algorithmics', 't [the number of expressions <= 100]
expression [length <= 400]
[other expressions]
Text grouped in [ ] does not appear in the input file.', 'The expressions in RPN form, one per line.', 459, 'medium', true);
INSERT INTO public.problem (id, name, author, content, category_name, input_description, output_description, number_of_accepted_solutions, difficulty, practice) VALUES (6, 'Hello, World!', 'karol', 'This is a hello world problem. You need to print the string "Hello, World!" on the screen.You do NOT need to read any input.', 'Java', 'No Input', 'The string "Hello, World!" as is.', 6236287, 'easy', true);



INSERT INTO public.test (id, problem_id, number, is_open, input, output, maximum_execution_time_ms) VALUES (1, 3, 0, true, '3
2
13
21', 'YES
YES
NO', 50);
INSERT INTO public.test (id, problem_id, number, is_open, input, output, maximum_execution_time_ms) VALUES (2, 3, 1, false, '3
2
13
21', 'YES
YES
NO', 50);
INSERT INTO public.test (id, problem_id, number, is_open, input, output, maximum_execution_time_ms) VALUES (3, 3, 2, false, '10
1
2
3
4
5
6
7
8
9
10', 'NO
YES
YES
NO
YES
NO
YES
NO
NO
NO', 50);
INSERT INTO public.test (id, problem_id, number, is_open, input, output, maximum_execution_time_ms) VALUES (4, 3, 3, false, '5
37
17
12
24
55', 'YES
YES
NO
NO
NO', 50);
INSERT INTO public.test (id, problem_id, number, is_open, input, output, maximum_execution_time_ms) VALUES (5, 4, 0, true, '10
1
2
3
4
5
6
7
8
9
10', '0
0
0
0
1
1
1
1
1
2', 60);
INSERT INTO public.test (id, problem_id, number, is_open, input, output, maximum_execution_time_ms) VALUES (6, 4, 1, false, '5
20
15
10
0
9', '4
3
2
0
1', 55);


INSERT INTO public.topic (id, name, category_name, theory, code_example, code_explanation) VALUES (1, 'if...else', 'Java', 'The if-then statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular test evaluates to true.', 'class IfElseDemo {
    public static void main(String[] args) {

        int testscore = 76;
        char grade;

        if (testscore >= 90) {
            grade = ''A'';
        } else if (testscore >= 80) {
            grade = ''B'';
        } else if (testscore >= 70) {
            grade = ''C'';
        } else if (testscore >= 60) {
            grade = ''D'';
        } else {
            grade = ''F'';
        }
        System.out.println("Grade = " + grade);
    }
}', 'You may have noticed that the value of testscore can satisfy more than one expression in the compound statement: 76 >= 70 and 76 >= 60. However, once a condition is satisfied, the appropriate statements are executed (grade = ''C'';) and the remaining conditions are not evaluated.');
INSERT INTO public.topic (id, name, category_name, theory, code_example, code_explanation) VALUES (2, 'for loops', 'Java', 'The for statement provides a compact way to iterate over a range of values. Programmers often refer to it as the "for loop" because of the way in which it repeatedly loops until a particular condition is satisfied.', 'class ForDemo {
    public static void main(String[] args){
         for(int i=1; i<11; i++){
              System.out.println("Count is: " + i);
         }
    }
}', '}
The output of this program is:

Count is: 1
Count is: 2
Count is: 3
Count is: 4
Count is: 5
Count is: 6
Count is: 7
Count is: 8
Count is: 9
Count is: 10');
INSERT INTO public.topic (id, name, category_name, theory, code_example, code_explanation) VALUES (3, 'enum types', 'Java', 'An enum type is a special data type that enables for a variable to be a set of predefined constants. The variable must be equal to one of the values that have been predefined for it. Common examples include compass directions (values of NORTH, SOUTH, EAST, and WEST) and the days of the week.

Because they are constants, the names of an enum type''s fields are in uppercase letters.

In the Java programming language, you define an enum type by using the enum keyword.', 'public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
}


public class EnumTest {
    Day day;

    public EnumTest(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better.");
                break;

            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    public static void main(String[] args) {
        EnumTest firstDay = new EnumTest(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}', 'The output is:

Mondays are bad.
Midweek days are so-so.
Fridays are better.
Weekends are best.
Weekends are best.
Java programming language enum types are much more powerful than their counterparts in other languages. The enum declaration defines a class (called an enum type). The enum class body can include methods and other fields. The compiler automatically adds some special methods when it creates an enum.');