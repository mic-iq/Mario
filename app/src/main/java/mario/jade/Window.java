package mario.jade;


//https://www.youtube.com/watch?v=025QFeZfeyM
//23:23

public class Window {
    private int width, height;
    private String title;
    private long glfwWindow;
    private static Window window = null;

    private Window() {
        this.width = 1024;
        this.height = 768;
        this.title = "Mario";

    }

    public static Window get(){
        if(Window.window == null){
            Window.window = new Window();
        }
        return Window.window;
    }

    public void run(){
        System.out.println("Hello LWJGL "+ "!");

        init();
        loop();
    }

        public void init(){
            //Setup an error callback
            GLFWErrorCallback.createPrint(System.err).set();

            //Inicializa GLFW
            if(!glfwInit()){
                throw new IllegalStateException("No puedo inicializar GLFW");
            }

            //configurar GLFW

            glfwDefaultWinfowHints();
            glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
            glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
            glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);

            //Crear ventana
            glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
            if(glfwWindow == NULL){
                throw new IllegalStateException("Fallo al crear la ventana GLFW");
            }

            //COntexto para OPENGL
            glfwMakeContextCurrent(glfwWindow);
            //activar v-sync
            glfwSwapInterval(1);
            //Hacer visible la ventana
            glfwShowWindow(glfwWindow);
            // This line is critical for LWJGL's interoperation with GLFW's    
            // OpenGL context, or any context that is managed externally.
		    // LWJGL detects the context that is current in the current thread,
		    // creates the GLCapabilities instance and makes the OpenGL
		    // bindings available for use.

            GL.createCapabilities();

        }

        public void loop(){
            while(!glfwWindowShouldClose(glfwWindow)){
                //Eventos
                glfwPollEvents();

                glClearColor( red: 1.0f, green:0.0f, blue:0.0f, alpha: 1.0f);
                glClear(GL_COLOR_BUFFER_BIT);

                glfwSwapBuffers(glfwWindow);
            }
        }
}
