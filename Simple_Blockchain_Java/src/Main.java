public class Main {

    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();
        Miner miner = new Miner();

        // Genesis block is manually mined to start the chain
        Block genesisBlock = new Block(0," block Genesis : ", Constants.GENESIS_HASH);
        miner.mines(blockChain, genesisBlock);

        // "Block number" staat voor deze presentatie op de plek waar je normaal gesproken de transacties zal vermelden om op te nemen
        // in de te berekenen hash zodat deze achteraf niet meer kunnen worden gewijzigd (want dan veranderd ook de hash natuurlijk)
        // De transacties zelf zijn op basis van een wallet adres (Public key = hash) en een transactie heeft daarnaast een
        // transactieHASH of messageSignature die gemaakt is met de private sleutel van de betreffende wallet waarmee
        // eventueel de saldo check en inkomsten/uitgave kunnen worden herleid en gecontroleerd
        for(int i=1; i < 10; i++){
            Block newBlock = new Block(i, " block number " + i + ": "  , blockChain.getBlockChain().get(blockChain.size()-1).getHash());
            miner.mines(blockChain, newBlock);
        }
    }
}