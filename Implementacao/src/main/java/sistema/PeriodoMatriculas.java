package sistema;

import java.util.Date;

public class PeriodoMatriculas {
    private Date dataInicio;
    private Date dataFim;
    private boolean ativo;
    
    public PeriodoMatriculas(Date dataInicio, Date dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.ativo = false;
    }
    
    public boolean verificarPeriodoAtivo() {
        if (!ativo) {
            return false;
        }
        
        Date agora = new Date();
        return agora.after(dataInicio) && agora.before(dataFim);
    }
    
    public void ativar() {
        this.ativo = true;
    }
    
    public void desativar() {
        this.ativo = false;
    }
    
    public Date getDataInicio() {
        return dataInicio;
    }
    
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    public Date getDataFim() {
        return dataFim;
    }
    
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public boolean dataDentroDoPeriodo(Date data) {
        return data.after(dataInicio) && data.before(dataFim);
    }
    
    @Override
    public String toString() {
        return "PeriodoMatriculas{" +
                "dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", ativo=" + ativo +
                '}';
    }
}
