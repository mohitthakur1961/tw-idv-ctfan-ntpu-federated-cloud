package tw.idv.ctfan.cloud.middleware.policy.data;

import java.util.HashMap;

import tw.idv.ctfan.cloud.middleware.Cluster.JobType;

/**
 * 
 * @author C.T.Fan
 * 
 * New Job Type, describing what a job like.  Except UID, all other attributes
 * are managed by java.util.HashMap.
 * 
 * Attributes are divided into two types: Continuous or Discrete.
 * Continuous value will be viewed as a Positive Long value.
 * Discrete value will takes more times to deal with, as our prediction tool
 * is Rough Set.
 *
 */

public class JobNode implements Comparable<JobNode> {
	
	
	/**
	 * Attribute type.  Help to manage job's attribute
	 * @author C.T.Fan
	 * @see JobNode#attributeType
	 *
	 */
	static public enum AttributeType {
		Continuous, Discrete
	}
	
	/**
	 * Representing job's status
	 * @author C.T.Fan
	 *
	 */
	static public enum JobStatus {
		Waiting, Running, Finished;
	}
	
	// Attributes that not in HashMap
	/**
	 * Job's UID
	 */
	public long UID;
	
	/**
	 * Job's status<br/>
	 * @see JobStatus
	 */
	public JobStatus status;
	
	/**
	 * The amount of time the job being executed.<br/>
	 * If the job is not finish, it shows the eclipse of the time.
	 */
	public long completionTime = -1;
	
	/**
	 * Deadline attribute.
	 */
	public long deadline;
	
	/**
	 * The type of the job.
	 * @see JobType
	 */
	public JobType jobType;
	
	/**
	 * The cluster the job is running on.<br/>
	 * null if not running on any cluster.
	 */
	public ClusterNode runningCluster = null;

	/**
	 * The attributes of a job.<br/>
	 * {@link JobNode#AddContinuousAttribute(String, long)}, {@link JobNode#AddDiscreteAttribute(String, String)} should be used to add attributes.<br/>
	 * {@link JobNode#GetContinuousAttribute(String)}, {@link JobNode#GetDiscreteAttribute(String)} should be used to get attribute values.<br/>
	 * The attribute key will be stored in {@link JobNode#attributes}.  Type of attribute will be check before adding/getting the value.
	 */
	private HashMap<String,String> attributes;
	
	/**
	 * Type of attributes.
	 * @see AttributeType
	 */
	static public HashMap<String, AttributeType> attributeType = new HashMap<String, AttributeType>();
	
	
	/**
	 * Default Constructor
	 */
	public JobNode(){
		this.UID = System.nanoTime();
		this.completionTime = -1;
		this.deadline = -1;
		attributes = new HashMap<String, String>();
	}
	
	/**
	 * @see JobNode#attributes
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean AddDiscreteAttribute(String key, String value){
		if(!attributeType.containsKey(key)) {
			attributeType.put(key, AttributeType.Discrete);
		} else if(attributeType.get(key)!=AttributeType.Discrete) {
			return true;
		}
		
		attributes.put(key, value);
		return false;
	}
	
	/**
	 * @see JobNode#attributes
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean AddContinuousAttribute(String key, long value) {
		if(!attributeType.containsKey(key)) {
			attributeType.put(key, AttributeType.Continuous);
		} else if(attributeType.get(key)!=AttributeType.Continuous) {
			return true;
		}
		
		attributes.put(key, Long.toString(value));
		return false;
	}
	
	/**
	 * @see JobNode#attributes
	 * @param key
	 * @return
	 */
	public String GetDiscreteAttribute(String key) {
		return attributes.get(key);
	}
	
	/**
	 * @see JobNode#attributes
	 * @param key
	 * @return
	 */
	public long GetContinuousAttribute(String key) {
		if(attributeType.get(key)==AttributeType.Continuous &&
				attributes.get(key)!=null)
			return Long.parseLong(attributes.get(key));
		return -1;
	}
	
	
	@Override
	public int compareTo(JobNode obj) {
		if(obj == this) return 0;
		return (int) (this.UID-((JobNode)obj).UID);
	}
	
	/**
	 * Simple function to display every attributes in a {@link JobNode}
	 */
	public void DisplayDetailedInfo() {
		System.out.println("-----Job Information-----");
		System.out.println("JobUID: " + this.UID);
		System.out.println("Deadline: " + this.deadline);
		for(String typeName: JobNode.attributeType.keySet()) {
			switch(JobNode.attributeType.get(typeName)) {
			case Discrete:{
				String s = this.GetDiscreteAttribute(typeName);
				System.out.println(typeName + ":" + (s==null?"null":s));
			}
			break;
			case Continuous:
				long l = this.GetContinuousAttribute(typeName);
				System.out.println(typeName + ":" + (l==-1?"null":l));
				break;
			}
		}
		System.out.println("-----The End of Job Information-----");
	}
}
