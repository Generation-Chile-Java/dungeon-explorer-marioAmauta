package objects;

import java.util.Random;

public class QuestionBank {
        private static final Question[] REACT_QUESTIONS = {
                        new Question(
                                        "¿Cuál es la forma correcta de definir un componente en React?",
                                        new String[] {
                                                        "function MyComponent() { return <div>Hello</div>; }",
                                                        "const MyComponent = () => <div>Hello</div>;",
                                                        "class MyComponent extends Component { render() { return <div>Hello</div>; } }",
                                                        "Todas las anteriores son correctas"
                                        },
                                        4),
                        new Question(
                                        "¿Qué hook se utiliza para manejar estado en componentes funcionales?",
                                        new String[] {
                                                        "useEffect",
                                                        "useState",
                                                        "useContext",
                                                        "useReducer"
                                        },
                                        2),
                        new Question(
                                        "¿Cuál es el propósito principal de useEffect?",
                                        new String[] {
                                                        "Manejar estado",
                                                        "Realizar efectos secundarios",
                                                        "Crear contexto",
                                                        "Memoizar valores"
                                        },
                                        2),
                        new Question(
                                        "¿Qué significa JSX?",
                                        new String[] {
                                                        "Java Syntax Extension",
                                                        "JavaScript XML",
                                                        "Just Simple XML",
                                                        "JavaScript eXtended"
                                        },
                                        2),
                        new Question(
                                        "¿Cuál es la forma correcta de pasar props a un componente hijo?",
                                        new String[] {
                                                        "<Child prop={value} />",
                                                        "<Child {prop: value} />",
                                                        "<Child prop=value />",
                                                        "<Child prop='value' />"
                                        },
                                        1),
                        new Question(
                                        "¿Qué es el Virtual DOM en React?",
                                        new String[] {
                                                        "Una copia del DOM real",
                                                        "Una representación en memoria del DOM",
                                                        "Un DOM más rápido",
                                                        "Todas las anteriores"
                                        },
                                        2),
                        new Question(
                                        "¿Cuál es la diferencia entre state y props?",
                                        new String[] {
                                                        "State es inmutable, props es mutable",
                                                        "State es mutable, props es inmutable",
                                                        "No hay diferencia",
                                                        "Props solo se usa en clases"
                                        },
                                        2),
                        new Question(
                                        "¿Qué hook usarías para optimizar el rendimiento evitando re-renders innecesarios?",
                                        new String[] {
                                                        "useState",
                                                        "useEffect",
                                                        "useMemo",
                                                        "useCallback"
                                        },
                                        3),
                        new Question(
                                        "¿Cuál es la forma correcta de manejar eventos en React?",
                                        new String[] {
                                                        "onclick=\"handleClick()\"",
                                                        "onClick={handleClick}",
                                                        "onClick=\"handleClick\"",
                                                        "onClic={handleClick()}"
                                        },
                                        2),
                        new Question(
                                        "¿Qué es React.Fragment?",
                                        new String[] {
                                                        "Un componente para crear formularios",
                                                        "Un wrapper que no añade nodos extra al DOM",
                                                        "Un hook para fragmentar estado",
                                                        "Una librería externa"
                                        },
                                        2)
        };

        public static Question getRandomQuestion() {
                Random random = new Random();

                return REACT_QUESTIONS[random.nextInt(REACT_QUESTIONS.length)];
        }
}
