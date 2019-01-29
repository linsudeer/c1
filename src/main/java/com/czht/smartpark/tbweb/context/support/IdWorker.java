package com.czht.smartpark.tbweb.context.support;
/**
 * SnowFlake 分布式ID生成方案 64位ID (0(1位占位，保证为正数) 41(毫秒)+5(机器ID)+5(业务编码)+12(重复累加))
 * 这里总共有 41+2+2+10=56位
 * @author lsl
 *
 */
public class IdWorker {
	
	private static final long TWEPOCH = 1518220800000L;
	
	/**
	 * 机器标识位数
	 */
	private static final long WORKER_ID_BITS = 2L;
	
	/**
	 * 数据中心标识位数
	 */
	private static final long DATACENTER_ID_BITS = 2L;
	
	/**
	 * 机器标识最大值  31
	 */
	private static final long MAX_WORKER_ID = -1L ^ (-1L << WORKER_ID_BITS);
	
	/**
	 * 数据中心标识最大值31
	 */
	private static final long MAX_DATACENTER_ID = -1L ^ (-1L << DATACENTER_ID_BITS);
	
	/**
	 * 毫秒内自增位数（1毫秒最大可生成到2^12-1=4095个）
	 */
	private static final long SEQUENCE_BITS = 10L;
	
	/**
	 * 机器ID偏左移12位
	 */
	private static long WORKER_ID_SHIFT = SEQUENCE_BITS;
	
	/**
	 * 数据中心左 12+5=17位
	 */
	private static long DATACENTER_ID_SHIFT = SEQUENCE_BITS + DATACENTER_ID_BITS;
	
	/**
	 * 时间毫秒左偏移 12+5+5=22位
	 */
	private static long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + DATACENTER_ID_BITS + WORKER_ID_BITS;
	
	/**
	 * mask 一个掩码 用来保证生成序号不大于4095
	 */
	private static final long SEQUENCE_MASK = -1L ^ (-1L << SEQUENCE_BITS);
	
	private long lastTimestamp = -1L;
	
	private long sequence = 0L;  
    private final long workerId;  
    private final long datacenterId;
    
    public IdWorker(){
    	this(MAX_WORKER_ID, MAX_DATACENTER_ID, 0L);
    }
    
	public IdWorker(long workerId, long datacenterId, long sequence){
		if(workerId > MAX_WORKER_ID || workerId <0){
			throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",MAX_WORKER_ID));
		}
		if(datacenterId > MAX_DATACENTER_ID || datacenterId <0){
			throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0",MAX_DATACENTER_ID));

		}
		
		this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
	}
	
	public long getWorkerId(){
        return workerId;
    }

    public long getDatacenterId(){
        return datacenterId;
    }

    public long getTimestamp(){
        return System.currentTimeMillis();
    }

    /**
     * 同步生成ID,返回结果先左移到指定位置，在位或拼接
     * @return
     */
    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;
        return ((timestamp - TWEPOCH) << TIMESTAMP_LEFT_SHIFT) |
                (datacenterId << DATACENTER_ID_SHIFT) |
                (workerId << WORKER_ID_SHIFT) |
                sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen(){
        return System.currentTimeMillis();
    }

    //---------------测试---------------
    public static void main(String[] args) {
        IdWorker worker = new IdWorker(1,1,12);
        for (int i = 0; i < 10; i++) {
            System.out.println(worker.nextId());
        }
    }
}
