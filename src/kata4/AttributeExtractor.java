package kata4;

//estamos creando un mecanismo par ausar el closure
public interface AttributeExtractor <Entity, Attribute>{
    public Attribute extract(Entity entity);
    
    
}
