package com.verint.fc.api.json;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by OBranopolsky on 17/06/2015.
 */

@Service
public class XmlMessage {
    private String name;
    public int getReatTO() {
			return reatTO;
		}

		public void setReatTO(int reatTO) {
			this.reatTO = reatTO;
		}

		public int getWriteTO() {
			return writeTO;
		}

		public void setWriteTO(int writeTO) {
			this.writeTO = writeTO;
		}

		private int reatTO;
    private int writeTO;
    private List<String> convertors;
    private List<String> validators;
    private List<String> executors;

    public List<String> getConvertors() {
			return convertors;
		}

		public void setConvertors(List<String> convertors) {
			this.convertors = convertors;
		}

		public List<String> getValidators() {
			return validators;
		}

		public void setValidators(List<String> validators) {
			this.validators = validators;
		}

		public List<String> getExecutors() {
			return executors;
		}

		public void setExecutors(List<String> executors) {
			this.executors = executors;
		}

		public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

 
 
}
