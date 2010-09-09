//: "The contents of this file are subject to the Mozilla Public License
//: Version 1.1 (the "License"); you may not use this file except in
//: compliance with the License. You may obtain a copy of the License at
//: http://www.mozilla.org/MPL/
//:
//: Software distributed under the License is distributed on an "AS IS"
//: basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
//: License for the specific language governing rights and limitations
//: under the License.
//:
//: The Original Code is Guanxi (http://www.guanxi.uhi.ac.uk).
//:
//: The Initial Developer of the Original Code is Alistair Young alistair@codebrane.com
//: All Rights Reserved.
//:

package org.guanxi.common.log;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.Logger;
import org.guanxi.common.GuanxiException;
import org.guanxi.common.Utils;

/**
 * Class that encapsulates logging using log4j
 *
 * @author Alistair Young alistair@googlemail.com
 */
public class Log4JLogger {
  /** The full path/name of the log4j config file */
  private String logConfigFile = null;
  /** Default date format for loggers to use */
  private String logLayout = null;
  /** The maximum size of the log file */
  private String logMaxFileSize = null;
  private int logMaxBackupIndex;

  /**
   * Initialises a Logger object with the setting given to the class at startup.
   *
   * @param config The Log4JLoggerConfig instance to use for configuration
   * @return Logger object initialised to the current settings
   * @throws GuanxiException if an error occurs
   */
  public Logger initLogger(Log4JLoggerConfig config) throws GuanxiException {
    // Setup a unique logger in case the different instances of the same class want to use different log files
    Logger log = Logger.getLogger(config.getClazz().getName() + Utils.getUniqueID());

    // this needs to configure the logger using the config but that system also needs to be revamped. should just load properties from a file
    
    return log;
  }

  // Setters
  public void setLogConfigFile(String logConfigFile) {
    this.logConfigFile = logConfigFile;
    DOMConfigurator.configure(this.logConfigFile);
  }
  public void setLogLayout(String logLayout) { this.logLayout = logLayout; }
  public void setLogMaxFileSize(String logMaxFileSize) { this.logMaxFileSize = logMaxFileSize; }
  public void setLogMaxBackupIndex(int logMaxBackupIndex) { this.logMaxBackupIndex = logMaxBackupIndex; }

  // Getters
  public String getLogConfigFile() { return logConfigFile; }
  public String getLogLayout() { return logLayout; }
  public String getLogMaxFileSize() { return logMaxFileSize; }
  public int getLogMaxBackupIndex() { return logMaxBackupIndex; }
}
