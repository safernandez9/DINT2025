package supabase;

import java.net.InetSocketAddress;
import java.net.Proxy;
import okhttp3.OkHttpClient;

public class SupabaseConfig {

    public static final String SUPABASE_URL = "https://xygjjewqwzzeobjzsiov.supabase.co";
    public static final String SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inh5Z2pqZXdxd3p6ZW9ianpzaW92Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjI1MDk4ODksImV4cCI6MjA3ODA4NTg4OX0.NhkjfLNXHJUu5bmFV78NIrPVVAHVyT_vy1oTV0EzLmo";
	 // En el terminal de Windows (set o setx)
	 // set SUPABASE_KEY=mi_clave_aqui
	 // set id_proyecto=id_proyecto
    // public static final String SUPABASE_URL = System.getenv("SUPABASE_URL");
    // public static final String SUPABASE_KEY = System.getenv("SUPABASE_KEY");
    

    // --- CONFIGURACIÓN DEL PROXY ---
    private static final boolean USE_PROXY = true; // cambia a false para desactivar
    private static final String PROXY_HOST = "192.168.0.11";
    private static final int PROXY_PORT = 3128;

    /**
     * Devuelve un OkHttpClient con o sin proxy, según configuración.
     */
    public static OkHttpClient getHttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        if (USE_PROXY) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_HOST, PROXY_PORT));
            client.proxy(proxy);
            System.out.println("🔌 Usando proxy: " + PROXY_HOST + ":" + PROXY_PORT);
        } else {
            System.out.println("🌐 Sin proxy (conexión directa).");
        }

        return client.build();
    }
}