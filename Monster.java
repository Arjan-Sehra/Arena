//Interface
interface Monster{
	//creating methods that I will use in more detail in the 2 classes that will implement this interface (Boss & Minion)
	public void strike(Character enemy);
	public void SyntaxError(Character enemy);
	public void NullPointerException();
	public void ArrayIndexOutOfBoundException(Character enemy);
}