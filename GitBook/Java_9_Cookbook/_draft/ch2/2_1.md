# Introduction

이 장에서는 OOP의 구성 요소에 대해 간략하게 소개하고 Java 8 및 Java 9의 이러한 구성 요소의 새로운 개선 사항에 대해 다룹니다. 또한 적절한 OOD (Object-Oriented Design) 관행에 대해서도 다룰 것입니다.

레시피 전반에 걸쳐 새로운 (Java 8 및 Java 9에서 소개 된) 향상된 기능을 사용하고 특정 코드 예제를 사용하여 OOD의 개념을 정의 및 보여 주며 더 나은 코드 문서화를 위한 새로운 기능을 제공합니다.

책이나 인터넷에서 OOD에 대한 기사와 실용적인 조언을 읽는 데 많은 시간을 할애 할 수 있습니다. 이 활동 중 일부는 어떤 사람들에게는 유익 할 수 있습니다. 그러나 우리의 경험에서 OOD를 잡는 가장 빠른 방법은 자신의 코드에서 초기 원칙을 시험해 보는 것입니다. 이것이 바로 이 장의 목표입니다. OOD 원칙을 보고 사용할 수 있는 기회를 제공하여 공식적인 정의가 즉시 의미를 갖도록 합니다.

잘 쓰여진 코드의 주된 기준 중 하나는 의도를 표현하는 명확성입니다. 잘 동기 부여되고 명확한 설계는 이를 달성하는 데 도움이됩니다. 이 코드는 컴퓨터에 의해 실행되지만 인간에 의해 유지되고 확장됩니다. 이것을 염두에 두면 당신이 작성한 코드의 장수와 심지어 감사와 감사의 표현까지 가능할 것입니다.

이 장에서는 5가지 기본 OOD 개념을 사용하는 방법을 학습합니다.

* 객체 / 클래스 - 데이터와 프로 시저를 함께 유지
* 캡슐화 - 데이터 및 / 또는 절차 숨기기
* 상속 - 다른 클래스 데이터 및 / 또는 프로 시저 확장
* 인터페이스 - 유형 구현 및 코딩 지연
* Polymorphism - 부모 클래스 참조가 자식 클래스 객체를 참조하는 데 사용될 때 모든 확장에 기본 클래스 유형 사용

이 개념은이 장에서 소개하는 코드 스니 j에서 정의되고 시연됩니다. 인터넷을 검색하면 방금 논의한 5 가지 사항에서 다른 많은 개념과 추가 사항을 도출 할 수 있습니다.

다음 텍스트는 OOD에 대한 사전 지식이 필요하지 않지만 Java로 코드를 작성한 경험이 도움이 될 것입니다. 코드 샘플은 Java 9와 완벽하게 호환됩니다. 더 나은 이해를 위해 제시된 예제를 실행 해보십시오.

또한 이 장의 팁과 권장 사항을 팀 경험의 맥락에서 필요에 맞게 적용하는 것이 좋습니다. 동료들과 새로 발견 한 지식을 공유하고 현 프로젝트에 대해 설명 된 원칙을 귀하의 도메인에 어떻게 적용 할 수 있는지 논의하십시오.



This chapter gives you a quick introduction to the components of OOP and covers the new enhancements in these components in Java 8 and Java 9. We will also try to cover a few good object-oriented design (OOD) practices wherever applicable.

Throughout the recipes, we will use the new (introduced in Java 8 and Java 9) enhancements, define and demonstrate the concepts of OOD using specific code examples, and present new capabilities for better code documentation.

One can spend many hours reading articles and practical advice on OOD in books and on the Internet. Some of this activity can be beneficial for some people. But, in our experience, the fastest way to get hold of OOD is to try its principles early in your own code. This is exactly the goal of this chapter: to give you a chance to see and use the OOD principles so that the formal definition makes sense immediately.

One of the main criteria of well-written code is its clarity of expressing its intent. A well-motivated and clear design helps achieve this. The code is run by a computer, but it is maintained and extended by humans. Keeping this in mind will assure longevity of the code written by you and perhaps even a few thanks and mentions with appreciation. 

In this chapter, you will learn how to use the five basic OOD concepts:

Object/Class - Keeping data and procedures together
Encapsulation - Hiding data and/or procedures
Inheritance - Extending another class data and/or procedures
Interface - Deferring the implementation and coding for a type
Polymorphism - Using the base class type for all its extensions when a parent class reference is used to refer to a child class object

These concepts will be defined and demonstrated in the code snippets presented in this chapter. If you search the Internet, you may notice that many other concepts and additions to them can be derived from the five points we just discussed.

Although the following text does not require prior knowledge of OOD, some experience of writing code in Java would be beneficial. The code samples are fully functional and compatible with Java 9. For better understanding, we recommend that you try to run the presented examples.

We also encourage you to adapt the tips and recommendations in this chapter to your needs in the context of your team experience. Consider sharing your new-found knowledge with your colleagues and discuss how the described principles can be applied to your domain, for your current project.