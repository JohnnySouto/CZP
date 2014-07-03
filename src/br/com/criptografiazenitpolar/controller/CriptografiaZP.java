package br.com.criptografiazenitpolar.controller;

/**
 *
 * @author Johnny Souto e-mail: falecomigo@johnnysouto.com.br
 */

public class CriptografiaZP implements ICriptografiaZP{
    
    private char[] txtCriptografado;
    private char[] txtDesCriptografado;
    private final char[] valorLetraOriginal = {'z','e','n','i','t','p','o','l','a','r','Z','E','N','I','T','P','O','L','A','R'};
    private final char[] valorLetraCriptografada = {'p','o','l','a','r','z','e','n','i','t','P','O','L','A','R','Z','E','N','I','T'};

    @Override
    public void CriptografarMensagem(String newTxtCriptografado){
        
        txtCriptografado = newTxtCriptografado.toCharArray();
        
        for (int i = 0; i < txtCriptografado.length; i++) {
            for (int j = 0; j < 20; j++) {
                if(txtCriptografado[i]==valorLetraOriginal[j]){
                    txtCriptografado[i]=valorLetraCriptografada[j];
                    break;
                }
            }
        }
 
        newTxtCriptografado = String.valueOf(txtCriptografado);

    }

    @Override
    public void DesCriptografarMensagem(String newTxtDesCriptografado) {
        
        txtDesCriptografado = newTxtDesCriptografado.toCharArray();
        
        for (int i = 0; i < txtDesCriptografado.length; i++) {
            for (int j = 0; j < 20; j++) {
                if(txtDesCriptografado[i]==valorLetraCriptografada[j]){
                    txtDesCriptografado[i]=valorLetraOriginal[j];
                    break;
                }
            }
        }
        
        newTxtDesCriptografado = String.valueOf(txtDesCriptografado);
        
    }
    
}