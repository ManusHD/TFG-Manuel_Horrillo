/**
 * Copyright (c) 2025 Manuel Horrillo
 * 
 * Sistema de Gestión Logística para Delim
 * Trabajo de Fin de Grado - Universidad de [TU UNIVERSIDAD]
 * 
 * Este software es propiedad intelectual de Manuel Horrillo.
 * Licenciado exclusivamente para uso comercial por parte de Delim S.L.
 * 
 * PROHIBIDO:
 * - Redistribución sin autorización
 * - Uso comercial por terceros
 * - Modificación sin consentimiento
 * - Ingeniería inversa
 * 
 * Para permisos adicionales contactar: mhorrillj@alumnos.unex.es
 */

/**
 * Información de copyright y licencia del proyecto
 * 
 * @author Manuel Horrillo
 * @since 2025
 */
public final class Copyright {
    
    public static final String AUTHOR = "Manuel Horrillo";
    public static final String YEAR = "2025";
    public static final String PROJECT = "Sistema de Gestión Logística para Delim";
    public static final String LICENSE = "Licencia Propietaria - Todos los derechos reservados";
    public static final String CONTACT = "mhorrillj@alumnos.unex.es";
    
    private Copyright() {
        // Utility class - no instantiation
    }
    
    public static String getFullCopyright() {
        return String.format("© %s %s - %s", YEAR, AUTHOR, PROJECT);
    }
}