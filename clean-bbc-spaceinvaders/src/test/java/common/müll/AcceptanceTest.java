package common.müll;

/*
@ExtendWith(ApplicationExtension.class)
class AcceptanceTest extends FxAcceptanceTest {

    @Start
    public void start(Stage stage) {
        super.setStage(stage);
    }

    @Test
    void gamescene_left_100perSec(FxRobot robot) {

        Navigator navigatorSpy = context.setMock(spy(new Navigator()));
        Factory factory = GameObjectFactoryForTesting.createOneSpaceship(context);
        context.setFactory(factory);
        GameObjects gameObjectsSpy = spy(new GameObjects(factory));
        context.setMock(gameObjectsSpy);
        when(gameObjectsSpy.alienExterminated()).thenReturn(false);
        when(gameObjectsSpy.mankindExterminated()).thenReturn(false);
        context.bind();

        context.startApp();

        robot.sleep(100);
        robot.press(KeyCode.SPACE);
        robot.sleep(100);

        verify(navigatorSpy).navigateTo(SceneType.GAME);
    }
/*
    @Test
    void gameover(FxRobot robot) {

        Navigator navigatorSpy = spy(new Navigator());
        context.setMock(navigatorSpy);

        List<ALIEN> list = new ArrayList<>();
        //list.add(new ALIEN(100, 100, context.getBean(Gun.class)));
        //list.add(new ALIEN(200, 100, context.getBean(Gun.class)));
        CopyOnWriteArrayList<GameObject> aliens = new CopyOnWriteArrayList(list);


        GameObjects gameObjectsSpy = mock(GameObjects.class);
        when(gameObjectsSpy.getAlienShips()).thenReturn(list);
        doCallRealMethod().when(gameObjectsSpy).update(anyDouble());
        doCallRealMethod().when(gameObjectsSpy).draw(any(GraphicsContext.class));
        when(gameObjectsSpy.alienExterminated()).thenReturn(false);
        when(gameObjectsSpy.mankindExterminated()).thenReturn(false);
        when(gameObjectsSpy.iterator()).thenReturn(aliens.iterator());

        context.setMock(gameObjectsSpy);

        context.bind();

        robot.sleep(500);
        robot.press(KeyCode.SPACE);
        robot.sleep(100);

        //verify(navigatorSpy).navigateTo(SceneType.GAME);
    }


    /*


       @Test
    void gamescene_left_100perSec(FxRobot robot) {
        Navigator navigatorSpy = spy(new Navigator());
        mocks.add(navigatorSpy);
        robot.sleep(500);
        robot.press(KeyCode.SPACE);
        robot.press(KeyCode.LEFT);
        robot.sleep(1100);

        assertThat(context.getBean(SPACESHIP.class).getX()).isGreaterThan((Const.SCREEN_WIDTH / 2) - 100);
    }

    @Test
    void gamescene_right_100perSec(FxRobot robot) {
        init();
        robot.sleep(500);
        robot.press(KeyCode.SPACE);
        robot.press(KeyCode.RIGHT);
        robot.sleep(1000);

        assertThat(context.getBean(SPACESHIP.class).getX()).isLessThan(100);
    }


    @Test
    @Order(2)
    void gameOverScene_start(FxRobot robot) {

        gameObjects.getAlienShips().subList(0, gameObjects.getAlienShips().size() - 1).forEach(alien -> gameObjects.remove(alien));
        gameObjects.add(new BOMB(spaceship.getX(),spaceship.getY() - 100));
        robot.sleep(100);
        robot.press(KeyCode.SPACE);
        robot.sleep(1000);

        Navigator navigatorSpy = this.context.getBean(Navigator.class);
        verify(navigatorSpy).navigateTo(SceneType.GAME_OVER);
    }


    @Test
    @Order(3)
    void gameWonScene_start(FxRobot robot) {

        robot.sleep(100);
        robot.press(KeyCode.SPACE);
        gameObjects.clear();
        robot.sleep(2000);
        Navigator navigatorSpy = this.context.getBean(Navigator.class);
        verify(navigatorSpy).navigateTo(SceneType.GAME_WON);
    }*/
//}

            /*if (gac.containsBean("gameObjects")){
                try {
                    gac.removeBeanDefinition("gameObjects");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                gac.registerBean(GameObject.class, new GameObjects(gac.getBean(SPACESHIP.class))) ;
            }*/