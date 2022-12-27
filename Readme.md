#Good practices for Junit Test cases 
1. test method name eg -> should_ReturnTrue_When_
2. Differences between Junit4 and Junit 5 
3. @Before  vs  @BeforeEach ,@After vs @AfterEach
4. @BeforeClass vs @BeforeAll
5. @ignore vs @Disable 
6. There is no need to write public

# Junit 4 
# @Test(expected =Exception.class)
public void test()
{}

# Junit 5
# @Test
 void test(){
   assertThrows(Exception.class, ()->{})
}

# Junit 4
# @Test(timeout =1)
public void test()
{}

# Junit 5
# @Test
void test(){
assertTimeout(Duration.ofMills(1),()->{})
}
