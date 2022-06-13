
import java.util.ArrayList;
import java.util.List;

public class Cuenta  {
	
	private double saldo;
	private Usuario usuario = new Usuario();
	private List<Gasto> gastos;
	private List<Ingreso> ingresos;
 	
	 
	public Cuenta (Usuario usuario) {
		this.usuario=usuario;
		this.saldo=0;	
		this.gastos=new ArrayList<Gasto>();
		this.ingresos=new ArrayList<Ingreso>();
	}
	
 
	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}
	public double getSaldo() {
		return saldo;
	} 
	
	public void setUsuario(Usuario usuario) {
		this.usuario=usuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	public List<Ingreso> getIngreso(){		
		return ingresos;
	}
	
	public List<Gasto> getGastos(){
		return gastos;
	}
	
	
	
	//AÑADIR INGRESOS
	public double addIngresos(String description, double cantidad) {
		Ingreso nuevoIngreso = new Ingreso (cantidad, description);
		this.ingresos.add(nuevoIngreso);
		this.saldo=this.saldo+cantidad;
		return saldo;
	}
	
	//AÑADIR GASTOS 
	public double addGastos(String description, double cantidad){
		try {
			this.saldo=this.saldo-cantidad;
			
			if(this.getSaldo()<0) {
				throw new GastoException();
			}
			
		}catch (GastoException exception) {
			return -1;
		}
		
		Gasto nuevoGasto = new Gasto(cantidad, description);
		this.gastos.add(nuevoGasto);
		
		return this.saldo; 
	}
	
	 
	@Override
	public String toString() {
		return "El usuario: "  + usuario.getNombre() + 
				", tiene un saldo de: " + this.saldo;
	} 
	
}
