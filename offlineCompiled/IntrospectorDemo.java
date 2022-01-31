public class IntrospectorDemo{
	public static void main(String args[]) {
		try {
			Class<?> c = Class.forName("Colors");
			BeanInfo beaninfo = Introspector.getBeanInfo(c);
			
			System.out.println("Properties: ");
			PropertyDescriptor[] propertyDescriptor = 
					beanInfo.getPropertyDescriptors();
			
			for(int i = 0; i<propertyDescriptor.length; i++) {
				System.out.println("\t" + propertyDescriptor[i].getName());
			}
		} catch(Exception e) {
			System.out.println("Exception caught." + e);
		}
	}
}