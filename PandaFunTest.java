package io.ipfs.api;

import io.ipfs.multiaddr.MultiAddress;
import io.ipfs.multihash.Multihash;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class PandaFunTest {
    //init the ipfs
    private final IPFS ipfs = new IPFS(new MultiAddress("/ip4/192.168.0.1/tcp/5001"));

    /**
     * add file to ipfs
     *
     * @throws IOException
     */
    @Test
    public void add() throws IOException {
        //upload file
        NamedStreamable.FileWrapper savefile = new NamedStreamable.FileWrapper(new File("/user/frank/a.txt"));
        MerkleNode result = ipfs.add(savefile).get(0);
        //get the ipfs file hash
        System.out.println(result.toJSONString());
    }

    /**
     * get file from ipfs
     *
     * @throws IOException
     */
    @Test
    public void download() throws IOException {
        //file's hash
        String hash = "QmcNsPV7QZFHKb2DNn8GWsU5dtd8zH5DNRa31geC63ceb4";
        Multihash filePointer = Multihash.fromBase58(hash);
        byte[] data = ipfs.cat(filePointer);
        //get ipfs file content
        String content = new String(data);
        //lets do some verify things
    }
}
