public class Miner {
    private double reward;

    public void mines(BlockChain blockChain, Block block) {
        while(notGoldenHash(block)) {
            block.generateHash();
            block.incrementNonce();
        }
        System.out.println(block + " has just been mined...");
        blockChain.addBlock(block);
        reward += Constants.MINER_REWARD;
    }

    //Miners will generate hash values until they find the right hash
    //that matches with the difficulty variable declared in class Constant
    public boolean notGoldenHash(Block block) {
        String leadingZeros = new String(new char[Constants.MINING_DIFFICULTY]).replace('\0', '0');
        return !block.getHash().substring(0, Constants.MINING_DIFFICULTY).equals(leadingZeros);
    }

    public double getReward() {
        return this.reward;
    }
}