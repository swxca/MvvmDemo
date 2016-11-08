package zhangtao.com.MvvmDemo.fast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.Date;

public class fastDevJson {
    public static String MarshalToString(Object data){
        return getGson().toJson(data);
    }
    public static <T> T UnmarshalFromString(String s, Class<T> t) throws JsonSyntaxException {
        return getGson().fromJson(s,t);
    }
    private static Gson gson;
    private static NSync.Once gsonOnce = new NSync.Once();
    private static Gson getGson(){
        gsonOnce.Do(new Runnable() {
            @Override
            public void run() {
                JsonSerializer<Date> ser = new JsonSerializer<Date>() {
                    @Override
                    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext
                            context) {
                        if (src==null){
                            return null;
                        }else{
                            return new JsonPrimitive(NTime.FormatGolangDate(src));
                        }
                    }
                };
                JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {
                    @Override
                    public Date deserialize(JsonElement json, Type typeOfT,
                                            JsonDeserializationContext context) throws JsonParseException {
                        if (json==null){
                            return null;
                        }else{
                            try {
                                return NTime.ParseGolangDate(json.getAsString());
                            }catch (Exception e){
                                throw new JsonParseException(e.getMessage());
                            }
                        }
                    }
                };
                gson = new GsonBuilder()
                        .registerTypeAdapter(Date.class, ser)
                        .registerTypeAdapter(Date.class, deser).create();
            }
        });
        return gson;
    }
}
