public class Main {

    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();
        Miner miner = new Miner();

        //Genesis block is manually mined to start the chain
        Block genesisBlock = new Block(0," block Genesis : ", Constants.GENESIS_HASH);
        miner.mines(blockChain, genesisBlock);

        for(int i=1; i < 10; i++){
            Block newBlock = new Block(i, " block number " + i + ": "  , blockChain.getBlockChain().get(blockChain.size()-1).getHash());
            miner.mines(blockChain, newBlock);
        }
    }
}